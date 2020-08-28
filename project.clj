(defproject org.clojars.touch/fleet "0.10.5-SNAPSHOT"
  :description "Templating System for Clojure"
  :url "http://github.com/Flamefork/fleet"
  :scm {:name "git"
        :url "https://github.com/Flamefork/fleet"}
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :signing {:gpg-key "ilia@flamefork.ru"}

  :dependencies [[org.clojure/clojure "1.8.0"]]
  :global-vars {*warn-on-reflection* true}
  :java-source-paths ["src"]
  :aot :all
  :pom-plugins [[com.theoryinpractise/clojure-maven-plugin "1.8.1"
                 {:extensions "true"
                  :executions ([:execution
                                [:id "clojure-compile"]
                                [:phase "compile"]
                                [:configuration
                                 [:sourceDirectories [:sourceDirectory "src"]]]
                                [:goals [:goal "compile"]]])}]])
