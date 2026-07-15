import chisel3._
import chisel3.util._
import redefine.rrm.mmu._

import org.chipsalliance.cde.config._
import freechips.rocketchip.diplomacy._

val p = new Config(new dut.DefaultMMUParams)


import _root_.circt.stage.ChiselStage
val dut = LazyModule(new redefine.rrm.mmu.dut.DUT_MMU()(p))
ChiselStage.emitCHIRRTL(dut.module)
