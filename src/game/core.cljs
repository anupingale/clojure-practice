(ns game.core
    (:require
      [reagent.core :as r]))

(def click-count (r/atom 0))
(def person-name (r/atom "strenger"))
;; -------------------------
;; View

(defn counter [] [:div
                  [:h2 "Current click is :  "  @click-count]
                  [:input {:type "button" :value "Increment"
                           :on-click #(swap! click-count inc)}]
                  [:input {:type "button" :value "Decrement"
                           :on-click #(swap! click-count dec)}]
                  ])

(defn custom-value [value] [:input
                       {:type "input-box"
                        :place-holder "Enter text here"
                        :on-change #(reset! value (-> % .-target .-value))
                        }])

(defn custom-greeting [] [:div
                          [:h2 "Hello " @person-name]
                          [:h2 [custom-value person-name]]
                          ])

(defn home-page [] (custom-greeting))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
