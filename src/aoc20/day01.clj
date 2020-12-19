(ns aoc20.day01
  (:require [clojure.java.io :as io]))

(def demo-input
  [1721
   979
   366
   299
   675
   1456])

(def real-input (read-string (str "[" (slurp (io/resource "day01.txt")) "]")))

(defn sum-2020 [a b] (= (+ a b) 2020))

(defn mul-2020 [input]
  (loop [[head & rest] input]
    (if-let [compl (filter #(sum-2020 head %) rest)]
      (* head (first compl))
      (recur rest))))

(mul-2020 demo-input)