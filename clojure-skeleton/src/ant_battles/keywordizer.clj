(ns ant-battles.keywordizer)

(defn keywordize [arg]
  (cond
    (map? arg) (into {}
                  (for [[k v] arg] [(keyword k) (keywordize v)]))
    (list? arg) (map keywordize arg)
    (vector? arg) (mapv keywordize arg)
    :else arg))
