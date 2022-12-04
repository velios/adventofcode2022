(ns adventofcode.day4
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
    (mapcat #(string/split % #","))
    (map #(string/split % #"-"))
    (map (fn [[a b]]
           (let [r (range (parse-long a)
                     (inc (parse-long b)))]
             r)
           ))
    (partition 2)))

(defn -main
  [& args]
  )

(comment
  


  ;; part 1
  (->> (slurp "resources/day4.in")
    (parse-input)
    (map (fn [[a b]]
           (if (or (clojure.set/subset? (set b) (set a))
                 (clojure.set/subset? (set a) (set b)))
             1
             0)))
    
    (apply +))

  
  ;; part 2
  (->> (slurp "resources/day4.in")
    (parse-input)
    )
  
  )

  