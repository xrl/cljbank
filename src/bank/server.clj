(ns bank.server
  (:use     (noir.core) (hiccup.core) (hiccup.form-helpers) (hiccup.page-helpers))
  (:require [noir.server :as server] )
)

(defpartial signup_form []
  (label "holder_name" "Your Name:"))
  
(defpage "/" []
  (html5
    [:head ""]
    [:body
      (signup_form)]
  )
)


(noir.core/defpage "/echo_post" []
  (html
    [:html
      [:head ""]
      [:body
        [:p "hi"]
        [:ul
          [:li "a thing"]
          [:li "another thing"]
          [:li "the last thing"]
        ]]
    ]
  ))

(defn -main [& m]
  (server/start 8080 {:ns `bank.server}))
; 
; (defn -main [& m]
;   (let [mode (keyword (or (first m) :dev))
;         port (Integer. (get (System/getenv) "PORT" "8080"))]
;     (server/start port {:mode mode
;                         :ns `noir-bak})))