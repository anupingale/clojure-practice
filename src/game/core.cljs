(ns game.core
    (:require
      [reagent.core :as r]))

(def click-count (r/atom 0))
;; -------------------------
;; View

(defn counter [] [:div
                  [:h2 "Current click is :  "  @click-count]
                  [:input {:type "button" :value "Increment"
                           :on-click #(swap! click-count inc)}]
                  [:input {:type "button" :value "Decrement"
                           :on-click #(swap! click-count dec)}]
                  ])

(defn home-page [] ( counter))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
