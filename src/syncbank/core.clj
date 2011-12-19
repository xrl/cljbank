(ns syncbank.core)

(defrecord Account [name balance])

(defn open-bank 
	"Returns reference to a hash of accounts (the bank database)"
	[] (ref {}))
	
				
(defn add-account 
	"adds a new account to bank b identified by name s and starting balance v or alters existing to v"
	[b s v]
	(dosync 
		(alter b assoc s (Account. s v))))

(defn deposit
	"deposits v into account s of bank b if it exists, or returns false if no such account"
	[b s v]
	(dosync
		(let [acc (b s)]
		(if acc (alter b assoc s (Account. s ( + (:balance acc) v))) false)))) 

(defn withdraw
	"withdraws v from account s of bank b if it exists, or returns false if no such account"
	[b s v]
		(dosync
			(let [acc (b s)]
				(if acc (alter b assoc s (Account. s ( - (:balance acc) v))) false))))

(defn assets
	"returns total assets of bank b"
	[b]
	(dosync (reduce + (map #(:balance (@b %)) (keys @b))))
)

(defn balance
	"returns balance of account s from bank b or false if no such account"
	[b s]
	(dosync (if (b s) (:balance (@b s)) false)))
	
(defn accounts
	"return sequence of account names in bank b"
	[b]
	(dosync (keys @b)))

