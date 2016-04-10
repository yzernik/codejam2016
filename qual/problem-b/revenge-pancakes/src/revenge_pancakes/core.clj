(ns revenge-pancakes.core
  (:gen-class))

(defn- solve []
  (let [pancakes (read-line)]
    (println
     (loop [cur-side \+
            count 0
            rem (reverse pancakes)]
       (if (empty? rem)
         count
         (recur (first rem)
                (+ count (if (= cur-side (first rem))
                           0
                           1))
                (rest rem)))))))

(defn -main
  [& args]
  (dotimes [t (read-string (read-line))]
    (print (str "Case #" (inc t) ": "))
    (solve)))
