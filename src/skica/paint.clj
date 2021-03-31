(ns skica.paint
  (:import [org.jetbrains.skija Paint FilterQuality PaintMode Color4f PaintStrokeCap PaintStrokeJoin Path Rect Shader ColorFilter BlendMode PathEffect
            MaskFilter ImageFilter]))

(def paint-mode
  {:fill           PaintMode/FILL
   :stroke         PaintMode/STROKE
   :stoke-and-fill PaintMode/STROKE_AND_FILL})

(def paint-stroke-cap
  {:butt   PaintStrokeCap/BUTT
   :round  PaintStrokeCap/ROUND
   :square PaintStrokeCap/SQUARE})

(def paint-stroke-join
  {:miter PaintStrokeJoin/MITER
   :round PaintStrokeJoin/ROUND
   :bevel PaintStrokeJoin/BEVEL})

(defn make-paint []
  (Paint.))

(defn make-clone [^Paint paint]
  (.makeClone paint))

(defn reset [^Paint paint]
  (.reset paint))

(defn anti-alias? [^Paint paint]
  (.isAntiAlias paint))

(defn set-anti-alias [^Paint paint value]
  (.setAntiAlias paint value))

(defn dither? [^Paint paint]
  (.isDither paint))

(defn set-dither [^Paint paint value]
  (.setDither paint value))

(defn get-filter-quality [^Paint paint]
  (.getFilterQuality paint))

(defn set-filter-quality [^Paint paint ^FilterQuality filter-quality]
  (.setFilterQuality paint filter-quality))

(defn get-mode [^Paint paint]
  (.getMode paint))

(defn set-mode [^Paint paint style]
  (.setMode paint (get paint-mode style)))

(defn set-stroke [^Paint paint value]
  (.setStroke paint value))

(defn get-color [^Paint paint]
  (.getColor paint))

(defn set-color [^Paint paint color]
  (.setColor paint (int color)))

(defn get-color4f [^Paint paint]
  (.getColor4f paint))

(defn set-color4f [^Paint paint ^Color4f color]
  (.setColor4f paint color))

(defn get-alpha [^Paint paint]
  (.getAlpha paint))

(defn set-alpha [^Paint paint a]
  (.setAlpha paint (int a)))

(defn get-alphaf [^Paint paint]
  (.getAlphaf paint))

(defn set-alphaf [^Paint paint a]
  (.setAlphaf paint (float a)))

(defn set-argb [^Paint paint a r g b]
  (.setARGB paint (int a) (int r) (int g) (int b)))

(defn get-stroke-width [^Paint paint]
  (.getStrokeWidth paint))

(defn set-stroke-width [^Paint paint width]
  (.setStrokeWidth paint (float width)))

(defn get-stroke-miter [^Paint paint]
  (.getStrokeMiter paint))

(defn set-stroke-miter [^Paint paint miter]
  (.setStrokeMiter paint miter))

(defn get-stroke-cap [^Paint paint]
  (.getStrokeCap paint))

(defn set-stroke-cap [^Paint paint cap]
  (.setStrokeCap paint (get paint-stroke-cap cap)))

(defn get-stroke-join [^Paint paint]
  (.getStrokeJoin paint))

(defn set-stroke-join [^Paint paint join]
  (.setStrokeJoin paint (get paint-stroke-join join)))

(defn get-fill-path
  ([^Paint paint ^Path src]
   (.getFillPath paint src))
  ([^Paint paint ^Path src ^Rect cull res-scale]
   (.getFillPath paint src cull (float res-scale))))

(defn get-shader [^Paint paint]
  (.getShader paint))

(defn set-shader [^Paint paint ^Shader shader]
  (.setShader paint shader))

(defn get-color-filter [^Paint paint]
  (.getColorFilter paint))

(defn set-color-filter [^Paint paint ^ColorFilter color-filter]
  (.setColorFilter paint color-filter))

(defn get-blend-mode [^Paint paint]
  (.getBlendMode paint))

(defn set-blend-mode [^Paint paint ^BlendMode mode]
  (.setBlendMode paint mode))

(defn src-over? [^Paint paint]
  (.isSrcOver paint))

(defn get-path-effect [^Paint paint]
  (.getPathEffect paint))

(defn set-path-effect [^Paint paint ^PathEffect p]
  (.setPathEffect paint p))

(defn get-mask-filter [^Paint paint]
  (.getMaskFilter paint))

(defn set-mask-filter [^Paint paint ^MaskFilter mask-filter]
  (.setMaskFilter paint mask-filter))

(defn get-image-filter [^Paint paint]
  (.getImageFilter paint))

(defn set-image-filter [^Paint paint ^ImageFilter image-filter]
  (.setImageFilter paint image-filter))

(defn has-nothing-to-draw? [^Paint paint]
  (.hasNothingToDraw paint))
