package kz.greepto.gpen.views.gpen.align.worker

import kz.greepto.gpen.drawport.DrawPort
import kz.greepto.gpen.drawport.Kolor
import kz.greepto.gpen.util.ColorManager

class AlignWorkerToBottomFromLeft implements AlignWorker {

  override paintIcon(DrawPort dp, ColorManager colors, int width, int height) {
    dp.style.foreground = Kolor.BLUE
    dp.from(10, 10).shift(40, 40).line
  }

}