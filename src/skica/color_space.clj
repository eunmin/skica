(ns skica.color-space
  (:import [org.jetbrains.skija ColorSpace Color4f]))

(defn get-srgb []
  (ColorSpace/getSRGB))

(defn get-srgb-linear []
  (ColorSpace/getSRGBLinear))

(defn get-display-p3 []
  (ColorSpace/getDisplayP3))

(defn convert [^ColorSpace color-space ^ColorSpace to ^Color4f color]
  (.convert color-space to color))

(defn gamma-close-to-srgb? [^ColorSpace color-space]
  (.isGammaCloseToSRGB color-space))

(defn gamma-linear? [^ColorSpace color-space]
  (.isGammaLinear color-space))

(defn is-srgb? [^ColorSpace color-space]
  (.isSRGB color-space))
