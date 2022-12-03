(ns adventofcode.day3
  (:require
    [clojure.string :as string]
    [clojure.set :as cset]
    [medley.core :as medley]))

(def item-score-map
  (zipmap (seq "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ") (rest (range 53))))

(defn parse-input
  [input]
  (->> input
    (string/split-lines)
    (map seq)
    ))

(defn split-by-two-equal-parts
  [input]
  (partition (/ (count input) 2) input))

(defn calculate-item-score
  [item]
  (get item-score-map item))

(defn calc-duplicate-item
  [input]
  (->> input 
    (map (fn [[a b]]
           (cset/intersection (set a) (set b))))
    (map first)))

(defn -main
  [& args]
  )

(comment
  
  (seq "abc")

  ;; part 1
  (->> (slurp "resources/day3.in")
    (parse-input)
    (map split-by-two-equal-parts)
    (calc-duplicate-item)
    (map calculate-item-score)
    (apply +))

  
  ;; part 2
  (->> (slurp "resources/day3.in")
    (parse-input)
    (partition 3)
    (map (fn [[a b с]]
           (cset/intersection (set a) (set b) (set с))))
    (map first)
    (map calculate-item-score)
    (apply +))
  
  )

  