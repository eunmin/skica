(ns skica.backend-render-target
  (:import org.jetbrains.skija.BackendRenderTarget))

(defn make-gl [width height sample-cnt stencil-bits fb-id fb-format]
  (BackendRenderTarget/makeGL (int width) (int height) (int sample-cnt) (int stencil-bits) (int fb-id) (int fb-format)))
