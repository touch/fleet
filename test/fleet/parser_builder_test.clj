(ns fleet.parser-builder-test
  (:use
    clojure.test
    [fleet parser builder]))

(deftest parse-test
  (let [tpl (slurp "test/resources/second/post_tpl.fleet")
        ast (slurp "test/resources/second/post_tpl.ast.clj")]
    (is (= (parse tpl) (read-string ast)))))

(deftest build-test
  (let [ast (read-string (slurp "test/resources/second/post_tpl.ast.clj"))
        clj (slurp "test/resources/second/post_tpl.clj")]
;    (println (build '(post) ast))
    (is (= (build '(post) ast) clj))))
