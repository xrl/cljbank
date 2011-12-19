(ns syncbank.core)

(defrecord Account [name balance])

(defn open-bank "Returns reference to a set of accounts (the bank database)"[] (ref #{}))
	
(defn add-account "adds a new account to bank b identified by name s and starting balance v"
	[b s v] (dosync (alter b conj (Account. s v))))
	