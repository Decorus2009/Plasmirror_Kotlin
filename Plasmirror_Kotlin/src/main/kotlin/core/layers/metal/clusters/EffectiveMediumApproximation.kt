package core.layers.metal.clusters

import core.layers.semiconductor.AlGaAs
import core.optics.*
import core.optics.metal.clusters.EffectiveMediumApproximation

/**
 * https://en.wikipedia.oxrg/wiki/Effective_medium_approximations
 * @param f  volume fraction of metal clusters in AlGaAs matrix
 * @return Maxwell-Garnett epsEff
 */
abstract class EffectiveMediumApproximationLayerOfMetalClustersInAlGaAs(
  d: Double,
  k: Double,
  x: Double,
  private val f: Double,
  epsType: EpsType
) : MetalClustersInAlGaAs, AlGaAs(d, k, x, epsType) {
  override val n
    get() = EffectiveMediumApproximation.permittivity(matrixPermittivity, clusterPermittivity, f).toRefractiveIndex()
}

class EffectiveMediumApproximationLayerOfDrudeMetalClustersInAlGaAs(
  d: Double,
  k: Double,
  x: Double,
  override val wPlasma: Double,
  override val gammaPlasma: Double,
  override val epsInf: Double,
  f: Double,
  epsType: EpsType
) : DrudeMetalClustersInAlGaAs, EffectiveMediumApproximationLayerOfMetalClustersInAlGaAs(d, k, x, f, epsType)

class EffectiveMediumApproximationLayerOfSbClustersInAlGaAs(
  d: Double,
  k: Double,
  x: Double,
  f: Double,
  epsType: EpsType
) : SbClustersInAlGaAs, EffectiveMediumApproximationLayerOfMetalClustersInAlGaAs(d, k, x, f, epsType)
