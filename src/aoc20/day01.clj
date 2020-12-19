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

(defn sum-c [a b c] (= (+ a b) c))

(defn mul-sum-2 [input sum]
  (loop [[head & rest] input]
    (if-not (empty? rest)
      (let [[compl] (filter #(sum-c head % sum) rest)]
        (if compl (* head compl) (recur rest))))))

(defn mul-sum-3 [input]
  (loop [[head & rest] input]
    (if-let [mul (mul-sum-2 rest (- 2020 head))]
      (* mul head)
      (recur rest))))

(mul-sum-2 real-input 2020)
(mul-sum-3 real-input)