(ns joker.core)

(defn get-random-number [limit]
  (let [num (rand-int limit)]
    (if (= 0 num)
      (recur limit)
      num)))

(defn joker
  ([]
   (joker [(get-random-number 46)]))
  ([nums]
   (let [unique-nums (-> nums distinct vec)]
     (if (= 6 (count unique-nums))
       unique-nums
       (let [random-num (get-random-number
                          (if (= 5 (count unique-nums)) 21 46))]
         (recur (conj unique-nums random-num)))))))

(defn joker-seq [value]
  (take value (repeatedly joker)))

(comment
  (joker-seq 5))
;; Will create 5 Joker columns like:
;; => ([40 23 2 20 29 11] [36 39 44 2 28 10] [15 24 31 21 40 14] [18 40 19 22 17 5] [43 12 1 31 2 4])
