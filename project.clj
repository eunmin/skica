(defproject eunmin/skica "0.1.0-SNAPSHOT"
  :description "Skija(Skia) binding for Clojure"
  :url "http://github.com/eunmin/skica"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :repositories {"jetbrains-skija" "https://packages.jetbrains.team/maven/p/skija/maven"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.jetbrains.skija/skija-macos-x64 "0.90.2"]]
  :repl-options {:init-ns skica.core})
