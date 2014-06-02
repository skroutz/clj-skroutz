(ns clj_skroutz.core
  (require [clj-http.client :as client])
  (require [cheshire.core :as json]))

;;; This is an incorrect implementation, such as might be written by
;;; someone who was used to a Lisp in which an empty list is equal to
;;; nil.
(defn first-element [sequence default]
  (if (nil? sequence)
    default
    (first sequence)))

