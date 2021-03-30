(ns skica.surface
  (:import [org.jetbrains.skija
            BackendRenderTarget ContentChangeMode DirectContext ImageInfo Surface SurfaceColorFormat SurfaceProps SurfaceOrigin
            ColorSpace IRect Canvas Paint Bitmap]))

(def origin {:top-left    SurfaceOrigin/TOP_LEFT
             :bottom-left SurfaceOrigin/BOTTOM_LEFT})

(def color-format {:unknown               SurfaceColorFormat/UNKNOWN
                   :alpha-8               SurfaceColorFormat/ALPHA_8
                   :rgb-565               SurfaceColorFormat/RGB_565
                   :argb-4444             SurfaceColorFormat/ARGB_4444
                   :rgba-8888             SurfaceColorFormat/RGBA_8888
                   :rgb-888x              SurfaceColorFormat/RGB_888x
                   :bgra-8888             SurfaceColorFormat/BGRA_8888
                   :rgba-1010102          SurfaceColorFormat/RGBA_1010102
                   :rgb-101010x           SurfaceColorFormat/RGB_101010x
                   :gray-8                SurfaceColorFormat/GRAY_8
                   :rgba-f16-norm         SurfaceColorFormat/RGBA_F16_NORM
                   :rgba-f16              SurfaceColorFormat/RGBA_F16
                   :rgba-f32              SurfaceColorFormat/RGBA_F32
                   :r8-g8-unorm           SurfaceColorFormat/R8G8_UNORM
                   :a16-float             SurfaceColorFormat/A16_UNORM
                   :r16-g16-float         SurfaceColorFormat/R16G16_FLOAT
                   :a16-unorm             SurfaceColorFormat/A16_UNORM
                   :r16-g16-unorm         SurfaceColorFormat/R16G16_UNORM
                   :r16-g16-b16-a16-unorm SurfaceColorFormat/R16G16B16A16_UNORM})

(defn make-raster-direct
  ([^ImageInfo image-info ^long pixels-ptr ^long row-bytes]
   (Surface/makeRasterDirect image-info pixels-ptr row-bytes))
  ([^ImageInfo image-info ^long pixels-ptr ^long row-bytes ^SurfaceProps surface-props]
   (Surface/makeRasterDirect image-info pixels-ptr row-bytes surface-props)))

(defn make-raster
  ([^ImageInfo image-info]
   (make-raster image-info 0 nil))
  ([^ImageInfo image-info ^long row-bytes]
   (make-raster image-info row-bytes nil))
  ([^ImageInfo image-info ^long row-bytes ^SurfaceProps surface-props]
   (Surface/makeRaster image-info row-bytes surface-props)))

(defn make-from-backend-render-target
  ([^DirectContext context
    ^BackendRenderTarget rt
    ^SurfaceOrigin origin
    ^SurfaceColorFormat color-format
    ^ColorSpace color-space]
   (make-from-backend-render-target context rt origin color-format color-space nil))
  ([^DirectContext context
    ^BackendRenderTarget rt
    ^SurfaceOrigin origin
    ^SurfaceColorFormat color-format
    ^ColorSpace color-space
    ^SurfaceProps surface-props]
   (Surface/makeFromBackendRenderTarget context rt origin color-format color-space surface-props)))

(defn make-raster-n32-premul [width height]
  (Surface/makeRasterN32Premul (int width) (int height)))

(defn make-render-target
  ([^DirectContext context
    budgeted
    ^ImageInfo image-info]
   (make-render-target context budgeted image-info (int 0) SurfaceOrigin/BOTTOM_LEFT nil false))
  ([^DirectContext context
    budgeted
    ^ImageInfo image-info
    sample-count
    ^SurfaceProps surface-props]
   (make-render-target context budgeted image-info (int sample-count) SurfaceOrigin/BOTTOM_LEFT surface-props false))
  ([^DirectContext context
    budgeted
    ^ImageInfo image-info
    sample-count
    ^SurfaceOrigin origin
    ^SurfaceProps surface-props]
   (make-render-target context budgeted image-info (int sample-count) origin surface-props false))
  ([^DirectContext context
    budgeted
    ^ImageInfo image-info
    sample-count
    ^SurfaceOrigin origin
    ^SurfaceProps surface-props
    should-create-with-mips]
   (Surface/makeRenderTarget context budgeted image-info (int sample-count) origin surface-props should-create-with-mips)))

(defn make-null [width height]
  (Surface/makeNull (int width) (int height)))

(defn get-width [^Surface surface]
  (.getWidth surface))

(defn get-height [^Surface surface]
  (.getHeight surface))

(defn get-image-info [^Surface surface]
  (.getImageInfo surface))

(defn get-generation-id [^Surface surface]
  (.getGenerationId surface))

(defn notify-content-will-change [^Surface surface ^ContentChangeMode mode]
  (.notifyContentWillChange surface mode))

(defn get-recording-context [^Surface surface]
  (.getRecordingContext surface))

(defn get-canvas [^Surface surface]
  (.getCanvas surface))

(defn make-surface
  ([^Surface surface ^ImageInfo image-info]
   (.makeSurface surface image-info))
  ([^Surface surface width height]
   (.makeSurface surface (int width) (int height))))

(defn make-image-snapshot [^Surface surface]
  (.makeImageSnapshot surface))

(defn makeImageSnapshot [^Surface surface ^IRect area]
  (.makeImageSnapshot surface area))

(defn draw [^Surface surface ^Canvas canvas x y ^Paint paint]
  (.draw surface canvas (int x) (int y) paint))

(defn read-pixels [^Surface surface ^Bitmap bitmap src-x src-y]
  (.readPixels surface bitmap src-x src-y))

(defn write-pixels [^Surface surface ^Bitmap bitmap x y]
  (.writePixels surface bitmap x y))

(defn flush-and-submit
  ([^Surface surface]
   (.flushAndSubmit surface))
  ([^Surface surface sync-cpu]
   (.flushAndSubmit surface sync-cpu)))

(defn flush-surface [^Surface surface]
  (.flush surface))

(defn unique? [^Surface surface]
  (.isUnique surface))
