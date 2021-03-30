(ns skica.direct-context
  (:import [org.jetbrains.skija DirectContext GLBackendState]))

(defn make-gl []
  (DirectContext/makeGL))

(defn flush-direct-context [^DirectContext direct-context]
  (.flush direct-context))

(defn reset-all [^DirectContext direct-context]
  (.resetAll direct-context))

(defn reset-gl [^DirectContext direct-context]
  (.resetGL direct-context))

(defn reset-gl-all [^DirectContext direct-context & states]
  (.resetGLAll direct-context (into-array GLBackendState states)))
