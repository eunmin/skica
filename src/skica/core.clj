(ns skica.core
  (:require [skica.paint :as paint]))

(defn paint [{:keys [anti-alias? dither? filter-quality color mode stroke color4f alphf alpha stroke-width stroke-miter stroke-cap stroke-join shader
                     color-filter blend-mode path-effect mask-filter image-filter]}]
  (cond-> (paint/make-paint)
          anti-alias? (paint/set-anti-alias anti-alias?)
          dither? (paint/set-dither dither?)
          filter-quality (paint/set-filter-quality filter-quality)
          color (paint/set-color color)
          mode (paint/set-mode mode)
          stroke (paint/set-stroke stroke)
          color4f (paint/set-color4f color4f)
          alphf (paint/set-alphaf alphf)
          alpha (paint/set-alpha alpha)
          stroke-width (paint/set-stroke-width stroke-width)
          stroke-miter (paint/set-stroke-miter stroke-miter)
          stroke-cap (paint/set-stroke-cap stroke-cap)
          stroke-join (paint/set-stroke-join stroke-join)
          shader (paint/set-shader shader)
          color-filter (paint/set-color-filter color-filter)
          blend-mode (paint/set-blend-mode blend-mode)
          path-effect (paint/set-path-effect path-effect)
          mask-filter (paint/set-mask-filter mask-filter)
          image-filter (paint/set-image-filter image-filter)))

(def framebuffer-format
  {:gr-gl-stencil-index     0x1901
   :gr-gl-depth-component   0x1902
   :gr-gl-depth-stencil     0x84F9
   :gr-gl-red               0x1903
   :gr-gl-red-integer       0x8D94
   :gr-gl-green             0x1904
   :gr-gl-blue              0x1905
   :gr-gl-alpha             0x1906
   :gr-gl-luminance         0x1909
   :gr-gl-luminance-alpha   0x190A
   :gr-gl-rg-integer        0x8228
   :gr-gl-rgb               0x1907
   :gr-gl-rgb-integer       0x8D98
   :gr-gl-srgb              0x8C40
   :gr-gl-rgba              0x1908
   :gr-gl-rg                0x8227
   :gr-gl-srgb-alpha        0x8C42
   :gr-gl-rgba-integer      0x8D99
   :gr-gl-bgra              0x80E1
   :gr-gl-stencil-index4    0x8D47
   :gr-gl-stencil-index8    0x8D48
   :gr-gl-stencil-index16   0x8D49
   :gr-gl-depth-component16 0x81A5
   :gr-gl-depth24-stencil8  0x88F0
   :gr-gl-r8                0x8229
   :gr-gl-r16               0x822A
   :gr-gl-r16-f             0x822D
   :gr-gl-r32-f             0x822E
   :gr-gl-r8-i              0x8231
   :gr-gl-r8-ui             0x8232
   :gr-gl-r16-i             0x8233
   :gr-gl-r16-ui            0x8234
   :gr-gl-r32-i             0x8235
   :gr-gl-r32-ui            0x8236
   :gr-gl-luminance8        0x8040
   :gr-gl-luminance16-f     0x881E
   :gr-gl-alpha8            0x803C
   :gr-gl-alpha16           0x803E
   :gr-gl-alpha16-f         0x881C
   :gr-gl-alpha32-f         0x8816
   :gr-gl-alpha8-i          0x8D90
   :gr-gl-alpha8-ui         0x8D7E
   :gr-gl-alpha16-i         0x8D8A
   :gr-gl-alpha16-ui        0x8D78
   :gr-gl-alpha32-i         0x8D84
   :gr-gl-alpha32-ui        0x8D72
   :gr-gl-rg8               0x822B
   :gr-gl-rg16              0x822C
   :gr-gl-rg16-f            0x822F
   :gr-gl-rg8-i             0x8237
   :gr-gl-rg8-ui            0x8238
   :gr-gl-rg16-i            0x8239
   :gr-gl-rg16-ui           0x823A
   :gr-gl-rg32-i            0x823B
   :gr-gl-rg32-ui           0x823C
   :gr-gl-rgb5              0x8050
   :gr-gl-rgb565            0x8D62
   :gr-gl-rgb8              0x8051
   :gr-gl-srgb8             0x8C41
   :gr-gl-rgb8-i            0x8D8F
   :gr-gl-rgb8-ui           0x8D7D
   :gr-gl-rgb16-i           0x8D89
   :gr-gl-rgb16-ui          0x8D77
   :gr-gl-rgb32-i           0x8D83
   :gr-gl-rgb32-ui          0x8D71
   :gr-gl-rgba4             0x8056
   :gr-gl-rgb5-a1           0x8057
   :gr-gl-rgba8             0x8058
   :gr-gl-rgb10-a2          0x8059
   :gr-gl-srgb8-alpha8      0x8C43
   :gr-gl-rgba16-f          0x881A
   :gr-gl-rgba32-f          0x8814
   :gr-gl-rg32-f            0x8230
   :gr-gl-rgba16            0x805B
   :gr-gl-rgba8-i           0x8D8E
   :gr-gl-rgba8-ui          0x8D7C
   :gr-gl-rgba16-i          0x8D88
   :gr-gl-rgba16-ui         0x8D76
   :gr-gl-rgba32-i          0x8D82
   :gr-gl-rgba32-ui         0x8D70
   :gr-gl-bgra8             0x93A1})
