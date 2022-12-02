(ns adventofcode.day2
  (:require
    [clojure.string :as string]
    [clojure.set :as cset]
    [medley.core :as medley]))

(defn parse-input
  [input]
  (->> input
    (string/split-lines)
    (map #(string/split % #" ")
      )
    ))

(def game-map
  {"X" {:score 1
        :op {"A" 3
             "B" 0
             "C" 6}}
   "Y" {:score 2
        :op {"A" 6
             "B" 3
             "C" 0}}
   "Z" {:score 3
        :op {"A" 0
             "B" 6
             "C" 3}}})

(def strategy-map 
  {"X" 0
   "Y" 3
   "Z" 6})

(defn calc-super-strategy-vec
  [vec game-map strategy-map]
  (let [[oponnent my] vec
        my-intent (get strategy-map my)
        my-turn-map (cset/map-invert
                      (medley/map-vals (fn [val]
                                         (-> val
                                           (:op)
                                           (cset/map-invert)
                                           (get my-intent)))
                        game-map))
        my-turn (get my-turn-map oponnent)]
    [oponnent my-turn]))

(defn calc-with-game-map-score
  [vec game-map]
  (let [[oponnent my] vec
        item-score (get-in game-map [my :score])
        play-score (get-in game-map [my :op oponnent])]
    (+ item-score play-score)))



(defn -main
  [& args]
  )

(comment
  
  ;; part 1
  (->> (slurp "resources/day2.in")
    (parse-input)
    (map #(calc-with-game-map-score % game-map))
    (apply +))

  
  ;; part 2
  (->> (slurp "resources/day2.in")
    (parse-input)
    (map #(calc-super-strategy-vec % game-map strategy-map))
    (map #(calc-with-game-map-score % game-map))
    (apply +))
  )

  