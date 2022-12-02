(ns adventofcode.day1
  (:require
    [clojure.string :as string]))

(defn parse-input
  [input]
  (->> input
    (string/split-lines)
    (mapv parse-long))
  )

(defn sort-by-asc
  [input]
  (->> input
    (partition-by #(nil? %))
    (mapv #(apply + %))
    (remove nil?)
    (sort >)))


(defn -main
  [& args]
  )

(comment
  ;; part 1
  (->> (slurp "resources/day1.in")
    (parse-input)
    (sort-by-asc)
    (first))
  
  (-> (slurp "resources/day1.in")
    (string/split #"\R\R"))
  
  ;; part 2
  (->> (slurp "resources/day1.in")
    (parse-input)
    (sort-by-asc)
    (take 3)
    (reduce +)))
  