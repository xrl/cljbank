(ns bank.core
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defn stuff [fred]
    (+ fred 1))
    
(defn tryme
  ([asdf] (+ asdf 1))
  ([a b]  (+ a b)))
  
(defpage "/" {} "hi")