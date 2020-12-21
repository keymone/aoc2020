(ns aoc20.day02
  (:require [clojure.string :refer [split]]
            [clojure.java.io :as io]))

(def demo-input
  "1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc")

(def real-input (slurp (io/resource "day02.txt")))

(defn parse-rule [rule-str]
  (let [[_ low high chr pwd] (re-matches #"(\d+)-(\d+) (.): (.+)" rule-str)]
    [(Integer/parseInt low) (Integer/parseInt high) (nth chr 0) pwd]))

(defn check [[low high char pwd]]
  (<= low (count (filter #(= % char) (seq pwd))) high))

(defn check2 [[fst snd char pwd]]
  (let [chars-at (set (map #(nth pwd (dec %)) [fst snd]))]
    (and (= 2 (count chars-at))
         (chars-at char))))

(->> (split real-input #"\n")
     (map parse-rule)
     (filter check2)
     count)
