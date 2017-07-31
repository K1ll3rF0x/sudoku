(ns sudoku
  (:require [clojure.set :as set]))

(def board identity)

(def all-values #{1 2 3 4 5 6 7 8 9})

(defn value-at [board coord]
  (get-in board coord))

(defn has-value? [board coord]
  (pos? (value-at board coord)))

(defn row-values [board [row col]]
  (set (get board row)))

(defn col-values [board [row col]]
  (set (map #(get %1 col) board)))

(defn coord-pairs [coords]
  (for [row coords
        col coords]
     [row col]))

(defn block-coord [[row col]]
  [(* 3 (int (/ row 3))) (* 3 (int (/ col 3)))])

(defn block-values [board coord]
  (let [[top-y top-x] (block-coord coord)]
    (set (for [y (range 3)
               x (range 3)]
           (value-at board [(+ y top-y) (+ x top-x)])))))

(defn valid-values-for [board coord]
  (if (has-value? board coord)
    #{}
    (set/difference all-values
                  (row-values board coord)
                  (col-values board coord)
                  (block-values board coord))))

(defn filled? [board]
  nil)

(defn rows [board]
  nil)

(defn valid-rows? [board]
  nil)

(defn cols [board]
  nil)

(defn valid-cols? [board]
  nil)

(defn blocks [board]
  nil)

(defn valid-blocks? [board]
  nil)

(defn valid-solution? [board]
  nil)

(defn set-value-at [board coord new-value]
  nil)

(defn find-empty-point [board]
  nil)

(defn solve [board]
  nil)
