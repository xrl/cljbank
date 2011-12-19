(ns syncbank.core)

(defrecord Account [name balance])

(defn open-bank [] (ref #{}))
	
(defn add-account [b s v] (dosync (alter b conj (Account. s v))))