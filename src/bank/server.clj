(ns bank.server
  (:require [noir.core] [noir.server :as server]))
  
(noir.core/defpage "/" []
  "hey there")

(defn -main [& m]
  (server/start 8080 {:ns `bank.server}))
; 
; (defn -main [& m]
;   (let [mode (keyword (or (first m) :dev))
;         port (Integer. (get (System/getenv) "PORT" "8080"))]
;     (server/start port {:mode mode
;                         :ns `noir-bak})))