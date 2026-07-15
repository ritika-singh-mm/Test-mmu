# Redefine Memory Management Unit (MMU)

MMU translates a kernels logical address to physical address mapped to offchip memory.

This project uses [playground](https://github.com/morphingmachines/playground.git) as a library. `playground` and `mmu` directories should be at the same level, as shown below.  
```
  workspace
  |-- playground
  |-- mmu
```
Make sure that you have a working [playground](https://github.com/morphingmachines/playground.git) project before proceeding further. And do not rename/modify `playground` directory structure.

## Clone the code
```sh
$ git clone https://github.com/morphingmachines/mmu.git
$ cd mmu
$ git submodule update --init
```

## Generating Verilog

Verilog code can be generated from Chisel by using the `rtl` Makefile target.

```sh
make rtl TARGET=MMU #other targets {SimMMU}
```
The output verilog files are generated in the ./generated_sv_dir directory. This also generates a graphml file that visualizes the diplomacy graph of different components in the system. To view graphml file, as shown below, use yEd.

## Scala console

```
$ make console
```
Load a design into the console for interactive probing of parameters as shown below
```
scala> :load inConsole.scala
```
inConsole.scala will load `MMU` DUT module with default parameters. You can query `MMU` module parameters as shown below.

```
scala> dut.params.fabric
val res1: redefine.FabricParams = FabricParams(8,8,2,2,4)
scala> dut.mmu.node.in(0)._1.a.bits.address.getWidth
val res2: Int = 35
```

### Run tests

```sh
make test
```

The output VCD files are dumped in the `./test_run_dir` directory.

More targets can be listed by running `make`.
