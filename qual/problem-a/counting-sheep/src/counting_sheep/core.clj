(ns counting-sheep.core
  (:require [clojure.set])
  (:gen-class))

(defn- digits-of-n [n]
  (set (str n)))

(defn- last-number [n]
  (if (zero? n) "INSOMNIA"
      (loop [i 1
             digits #{}]
        (let [prod (* i n)
              new-digs (clojure.set/union digits (digits-of-n prod))]
          (if (= 10 (count new-digs))
            (* i n)
            (recur (inc i) new-digs))))))

(defn- solve []
  (let [n (read)]
    (println (last-number n))))

(defn -main
  [& args]
  (dotimes [t (read)]
    (print (str "Case #" (inc t) ": "))
    (solve)))
