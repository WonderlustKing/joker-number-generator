(ns joker.core)

(defn get-random-number-to [x]
  (let [num (rand-int x)]
    (if (= 0 num)
      (recur x)
      num)))

(defn joker
  ([]
   (joker [(get-random-number-to 46)]))
  ([nums]
   (let [unique-nums (-> nums distinct vec)]
     (if (= 6 (count unique-nums))
       unique-nums
       (let [random-num (get-random-number-to
                          (if (= 5 (count unique-nums)) 21 46))]
         (recur (conj unique-nums random-num)))))))

(defn joker-seq [value]
  (take value (repeatedly joker)))
