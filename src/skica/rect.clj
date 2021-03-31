(ns skica.rect
  (:import [org.jetbrains.skija Rect Point]))

(defn make-ltrb [l t r b]
  (Rect/makeLTRB (float l) (float t) (float r) (float b)))

(defn make-wh
  ([w h]
   (Rect/makeWH (float w) (float h)))
  ([^Point size]
   (Rect/makeWH size)))

(defn make-xywh [l t w h]
  (Rect/makeXYWH (float l) (float t) (float w) (float h)))

(defn get-width [^Rect rect]
  (.getWidth rect))

(defn get-height [^Rect rect]
  (.getHeight rect))

(defn intersect [^Rect rect ^Rect other]
  (.intersect rect other))

(defn scale
  ([^Rect rect scale]
   (.scale rect scale))
  ([^Rect rect sx sy]
   (.scale rect (float sx) (float sy))))

(defn offset
  ([^Rect rect ^Point vec]
   (.offset rect vec))
  ([^Rect rect dx dy]
   (.offset rect (float dx) (float dy))))

(defn ->irect [^Rect rect]
  (.toIRect rect))
