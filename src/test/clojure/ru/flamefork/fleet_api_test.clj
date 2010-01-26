(ns ru.flamefork.fleet-api-test
  (:use
    [clojure.test]
    [ru.flamefork.fleet]))

(def test-posts [{:body "First post."}
                 {:body "Second post."}])

(def test-data {:title "Posts"})

(deftest fleet-ns-test
  (fleet-ns "src/test/fleet/ns")
  (is (=
    ((resolve 'posts/posts-html) test-posts test-data)
    (slurp "src/test/fleet/ns/posts/posts.html"))))
