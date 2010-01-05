(ns ru.flamefork.fleet
  (:use
    [clojure.contrib.def]
    [ru.flamefork.fleet loader parser compiler]))

(defvar search-paths
  (atom [])
  "Template files search paths.")

(defn add-search-path
  "Add path to end of search path list."
  [path]
  (swap! search-paths conj path))

(defn fleet
  "Creates anonymous function from template containing in template-str."
  [args template-str]
  (compile-to-fn args (parse template-str)))

(defn- read-template
  [fn-name]
  (slurp (.getPath (find-file (name fn-name) @search-paths))))

(defmacro deftemplate
  "Creates function with name fn-name and defined args from source.
  Source could be ommited, in this case Fleet will inflect template file name from fn-name."
  ([fn-name args]
    `(def ~fn-name (fleet '~args (@#'ru.flamefork.fleet/read-template '~fn-name))))
  ([fn-name args source]
    `(def ~fn-name (fleet '~args ~source))))
