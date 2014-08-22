(ns clj_skroutz.notifications
  "Implements user notifications endpoints

   http://developer.skroutz.gr/api/v3/notifications/"
  (:use [clj_skroutz.core :refer [api-call]]))

(defn all
  "Lists all notifications of a user.

   http://developer.skroutz.gr/api/v3/notifications/#list-notifications"
  [& options]
  (api-call :get "notifications" [] options))

(defn notification
  "Gets a user notifications

   http://developer.skroutz.gr/api/v3/notifications/#retrieve-a-single-notification"
  [id & options]
  (api-call :get "notifications/%s" [id] options))
