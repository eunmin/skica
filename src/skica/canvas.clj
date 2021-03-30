(ns skica.canvas
  (:import [org.jetbrains.skija Bitmap Canvas SurfaceProps Paint Rect RRect Path Image Matrix33 Matrix44 Region ClipMode Font TextBlob TextLine
            Picture Drawable BlendMode IRect FilterMode SamplingMode]))

(defn make-canvas
  ([^Bitmap bitmap]
   (Canvas. bitmap))
  ([^Bitmap bitmap ^SurfaceProps surface-props]
   (Canvas. bitmap surface-props)))

(defn draw-point [^Canvas canvas x y ^Paint paint]
  (.drawPoint canvas (float x) (float y) paint))

(defn draw-points [^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" coords ^Paint paint]
  (.drawPoints canvas coords paint))

(defn draw-float-points [^Canvas canvas coords ^Paint paint]
  (.drawPoints canvas (floats coords) paint))

(defn drawLine [^Canvas canvas x0 y0 x1 y1 ^Paint paint]
  (.drawLine canvas (float x0) (float y0) (float x1) (float y1) paint))

(defn draw-lines [^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" coords ^Paint paint]
  (.drawLines canvas coords paint))

(defn draw-float-lines [^Canvas canvas coords ^Paint paint]
  (.drawLines canvas (floats coords) paint))

(defn draw-polygon [^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" coords ^Paint paint]
  (.drawPolygon canvas coords paint))

(defn draw-float-polygon [^Canvas canvas coords ^Paint paint]
  (.drawPolygon canvas (floats coords) paint))

(defn draw-arc [^Canvas canvas left top right bottom start-angle sweep-angle include-center ^Paint paint]
  (.drawArc canvas (float left) (float top) (float right) (float bottom) (float start-angle) (float sweep-angle) include-center paint))

(defn draw-rect [^Canvas canvas ^Rect r ^Paint paint]
  (.drawRect canvas r paint))

(defn draw-oval [^Canvas canvas ^Rect r ^Paint paint]
  (.drawOval canvas r paint))

(defn draw-circle [^Canvas canvas x y radius ^Paint paint]
  (.drawCircle canvas (float x) (float y) (float radius) paint))

(defn draw-r-rect [^Canvas canvas ^RRect r ^Paint paint]
  (.drawRRect canvas r paint))

(defn draw-dr-rect [^Canvas canvas ^RRect outer ^RRect inner ^Paint paint]
  (.drawDRRect canvas outer inner paint))

(defn draw-path [^Canvas canvas ^Path path ^Paint paint]
  (.drawPath canvas path paint))

(defn draw-image
  ([^Canvas canvas ^Image image left top]
   (.drawImage canvas image (float left) (float top)))
  ([^Canvas canvas ^Image image left top ^Paint paint]
   (.drawImage canvas image (float left) (float top) paint)))

(defn draw-image-rect
  ([^Canvas canvas ^Image image ^Rect dst]
   (.drawImageRect canvas image dst))
  ([^Canvas canvas ^Image image ^Rect src ^Rect dst ^Paint paint]
   (if paint
     (if src
       (.drawImageRect canvas image src dst paint)
       (.drawImageRect canvas image dst paint))
     (.drawImageRect canvas image src dst)))
  ([^Canvas canvas ^Image image ^Rect src ^Rect dst ^Paint paint strict]
   (.drawImageRect canvas image src dst paint strict))
  ([^Canvas canvas ^Image image ^Rect src ^Rect dst ^SamplingMode sampling-mode ^Paint paint strict]
   (.drawImageRect canvas image src dst sampling-mode paint strict)))

(defn draw-image-nine [^Canvas canvas ^Image image ^IRect center ^Rect dst ^FilterMode filter-mode ^Paint paint]
  (.drawImageNine canvas image center dst filter-mode paint))

(defn draw-region [^Canvas canvas ^Region r ^Paint paint]
  (.drawRegion canvas r paint))

(defn draw-string [^Canvas canvas ^String s x y ^Font font ^Paint paint]
  (.drawString canvas s (float x) (float y) font paint))

(defn draw-text-blob [^Canvas canvas ^TextBlob blob x y ^Paint paint]
  (.drawTextBlob canvas blob (float x) (float y) paint))

(defn draw-text-line [^Canvas canvas ^TextLine line x y ^Paint paint]
  (.drawTextLine canvas line (float x) (float y) paint))

(defn draw-picture
  ([^Canvas canvas ^Picture picture]
   (.drawPicture canvas picture))
  ([^Canvas canvas ^Picture picture ^Matrix33 matrix ^Paint paint]
   (.drawPicture canvas picture matrix paint)))

(defn draw-triangles
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^Paint paint]
   (.drawTriangles canvas positions (int-array colors) paint))
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^"[Lorg.jetbrains.skija.Point;" tex-coords indices ^Paint paint]
   (.drawTriangles canvas positions (int-array colors) tex-coords (short-array indices) paint))
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^"[Lorg.jetbrains.skija.Point;" tex-coords indices ^BlendMode mode ^Paint paint]
   (.drawTriangles canvas positions (int-array colors) tex-coords indices mode paint)))

(defn draw-triangle-strip
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^Paint paint]
   (.drawTriangleStrip canvas positions (int-array colors) paint))
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^"[Lorg.jetbrains.skija.Point;" tex-coords indices ^Paint paint]
   (.drawTriangleStrip canvas positions (int-array colors) tex-coords (short-array indices) paint))
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^"[Lorg.jetbrains.skija.Point;" tex-coords indices ^BlendMode mode ^Paint paint]
   (.drawTriangleStrip canvas positions (int-array colors) tex-coords indices mode paint)))

(defn draw-triangle-fan
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^Paint paint]
   (.drawTriangleFan canvas positions (int-array colors) paint))
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^"[Lorg.jetbrains.skija.Point;" tex-coords indices ^Paint paint]
   (.drawTriangleFan canvas positions (int-array colors) tex-coords (short-array indices) paint))
  ([^Canvas canvas ^"[Lorg.jetbrains.skija.Point;" positions colors ^"[Lorg.jetbrains.skija.Point;" tex-coords indices ^BlendMode mode ^Paint paint]
   (.drawTriangleFan canvas positions (int-array colors) tex-coords (short-array indices) mode paint)))

(defn draw-drawable
  ([^Canvas canvas ^Drawable drawable]
   (.drawDrawable canvas drawable))
  ([^Canvas canvas ^Drawable drawable ^Matrix33 matrix]
   (.drawDrawable canvas drawable matrix))
  ([^Canvas canvas ^Drawable drawable x y]
   (.drawDrawable canvas drawable (float x) (float y))))

(defn clear [^Canvas canvas color]
  (.clear canvas (int color)))

(defn draw-paint [^Canvas canvas ^Paint paint]
  (.drawPaint canvas paint))

(defn set-matrix [^Canvas canvas ^Matrix33 matrix]
  (.setMatrix canvas matrix))

(defn reset-matrix [^Canvas canvas ^Matrix33 matrix]
  (.resetMatrix canvas matrix))

(defn get-local-to-device [^Canvas canvas]
  (.getLocalToDevice canvas))

(defn get-local-to-device-as-matrix33 [^Canvas canvas]
  (.getLocalToDeviceAsMatrix33 canvas))

(defn clip-rect
  ([^Canvas canvas ^Rect r]
   (.clipRect canvas r))
  ([^Canvas canvas ^Rect r ^ClipMode mode anti-alias]
   (if mode
     (.clipRect canvas r mode anti-alias)
     (.clipRect canvas r (boolean anti-alias)))))

(defn clip-r-rect
  ([^Canvas canvas ^RRect r]
   (.clipRRect canvas r))
  ([^Canvas canvas ^RRect r ^ClipMode mode anti-alias]
   (if mode
     (.clipRRect canvas r mode anti-alias)
     (.clipRRect canvas r (boolean anti-alias)))))

(defn clip-path
  ([^Canvas canvas ^Path r]
   (.clipPath canvas r))
  ([^Canvas canvas ^Path r ^ClipMode mode anti-alias]
   (if mode
     (.clipPath canvas r mode anti-alias)
     (.clipPath canvas r (boolean anti-alias)))))

(defn clip-region
  ([^Canvas canvas ^Region r]
   (.clipRegion canvas r))
  ([^Canvas canvas ^Region r ^ClipMode mode]
   (.clipRegion canvas r mode)))

(defn translate [^Canvas canvas dx dy]
  (.translate canvas (float dx) (float dy)))

(defn scale [^Canvas canvas sx sy]
  (.scale canvas (float sx) (float sy)))

(defn rotate [^Canvas canvas deg]
  (.rotate canvas (float deg)))

(defn skew [^Canvas canvas sx sy]
  (.skew canvas (float sx) (float sy)))

(defn concat-matrix33 [^Canvas canvas ^Matrix33 matrix]
  (.concat canvas matrix))

(defn concat-matrix44 [^Canvas canvas ^Matrix44 matrix]
  (.concat canvas matrix))

(defn read-pixels [^Canvas canvas ^Bitmap bitmap src-x src-y]
  (.readPixels canvas bitmap (int src-x) (int src-y)))

(defn writePixels [^Canvas canvas ^Bitmap bitmap x y]
  (.writePixels canvas bitmap (int x) (int y)))

(defn save [^Canvas canvas]
  (.save canvas))

(defn save-layer
  ([^Canvas canvas ^Rect bounds ^Paint paint]
   (.saveLayer canvas bounds paint))
  ([^Canvas canvas left top right bottom ^Paint paint]
   (.saveLayer canvas (float left) (float top) (float right) (float bottom) paint)))

(defn get-save-count [^Canvas canvas]
  (.getSaveCount canvas))

(defn restore [^Canvas canvas]
  (.restore canvas))

(defn restore-to-count [^Canvas canvas save-count]
  (.restoreToCount canvas (int save-count)))
