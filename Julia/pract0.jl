

println("hello world")
Pkg.available()
Pkg.add("Calculus")
Pkg.installed()
Pkg.update()

using Calculus
derivative(x -> sin(x), 1.0)

import Calculus
Calculus.derivative(x -> cos(x), 1.0)

Pkg.add("Winston")
Pkg.add("Gadfly")

import Winston
import Gadfly

Winston.plot(rand(4))


