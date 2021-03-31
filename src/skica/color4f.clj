(ns skica.color4f
  (:import [org.jetbrains.skija Color4f]))

(defn make-color4f
  ([c]
   (Color4f. (int c)))
  ([r g b]
   (Color4f. (float r) (float g) (float b)))
  ([r g b a]
   (Color4f. (float r) (float g) (float b) (float a))))

(defn to-color [^Color4f color4f]
  (.toColor color4f))

(defn flatten-floats [^Color4f color4f]
  (.flatten color4f))

(defn flatten-array [^"[Lorg.jetbrains.skija.Color4f;" colors]
  (Color4f/flattenArray colors))

(defn make-lerp [^Color4f color4f ^Color4f other weight]
  (.makeLerp color4f other (float weight)))
