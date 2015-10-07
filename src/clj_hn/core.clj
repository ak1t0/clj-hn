(ns clj-hn.core
  (:require [org.httpkit.client :as http]
            [clj-json.core :as json]
            [plumbing.core :refer [map-keys]])
  (:use [clojure.tools.namespace.repl :only [refresh]]))

;; util function
(defn take-body [x]
  (@x :body))

(defn take-json [obj]
  (json/parse-string (:body @obj)))

(defn take-json-k [obj]
  (map-keys keyword
    (json/parse-string (:body @obj))))

(defn gen-url [x]
  (str "https://hacker-news.firebaseio.com/v0/item/" x ".json"))

;; library function
(defn get-topstories []
  (-> "https://hacker-news.firebaseio.com/v0/topstories.json"
      (http/get)
      (take-json)))

(defn get-newstories []
  (-> "https://hacker-news.firebaseio.com/v0/newstories.json"
      (http/get)
      (take-json)))

(defn get-askstories []
  (-> "https://hacker-news.firebaseio.com/v0/askstories.json"
      (http/get)
      (take-json)))

(defn get-jobstories []
  (-> "https://hacker-news.firebaseio.com/v0/jobstories.json"
      (http/get)
      (take-json)))

(defn get-showstories []
  (-> "https://hacker-news.firebaseio.com/v0/showstories.json"
      (http/get)
      (take-json)))

(defn get-json [x]
  (-> (str "https://hacker-news.firebaseio.com/v0/item/" x ".json")
      (http/get)
      (take-json-k)))

(defn get-jsons [id]
  (->> id
    (map gen-url)
    (map http/get)
    (map take-json-k)))
