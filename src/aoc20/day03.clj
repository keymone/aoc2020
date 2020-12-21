(ns aoc20.day03
  (:require [clojure.string :refer [split]]
            [clojure.java.io :as io]))

(def real-input (slurp (io/resource "day03.txt")))

(defn grid [pattern] (map cycle (filter #(not= % "") (split pattern #"\n"))))
(defn tree-at? [grid x y] (= (nth (nth grid y) x) \#))

(defn trees [grid sx sy]
  (loop [x 0 y 0 t 0]
    (if (>= y (count grid))
      t
      (recur (+ sx x)
             (+ sy y)
             (+ t (if (tree-at? grid x y) 1 0))))))

(* (trees (grid real-input) 1 1)
   (trees (grid real-input) 3 1)
   (trees (grid real-input) 5 1)
   (trees (grid real-input) 7 1)
   (trees (grid real-input) 1 2))