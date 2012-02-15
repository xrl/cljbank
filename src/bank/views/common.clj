(ns bank.views.common
  (:use [noir.core] [hiccup.page-helpers] [hiccup.form-helpers]))

(defpartial layout [& content]
(html5
[:head
[:title "Forms"]]
[:body
content]))


(defpartial user-fields [{:keys [firstname lastname]}]
(label "firstname" "First name: ")
(text-field "firstname" firstname)
(label "lastname" "Last name: ")
(text-field "lastname" lastname))

(defpage "/user/add" {:as user}
(layout
(form-to [:post "/user/add"]
(user-fields user)
(submit-button "Add user"))))


(noir.core/defpage "/echo_post" []
  (html5
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

