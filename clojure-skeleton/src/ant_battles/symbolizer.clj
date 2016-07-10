(ns ant-battles.symbolizer)

(defn symbolize [arg]
  (cond
    (map? arg) (into {}
                  (for [[k v] arg] [(keyword k) (symbolize v)]))
    (list? arg) (map symbolize arg)
    (vector? arg) (mapv symbolize arg)
    :else arg))
