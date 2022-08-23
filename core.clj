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
;; Will create 5 Joker columns 
