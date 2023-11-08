package com.jason.chapter01.domain

import java.util.function.Predicate
import java.util.stream.Collectors

class Router(val routerType: RouterType, private val routerId: RouterId) {

    companion object {
        fun filterRouterByType(routerType: RouterType): Predicate<Router> {
            return if (routerType == RouterType.CORE) isCore else isEdge
        }

        private val isCore: Predicate<Router>
            get() = Predicate<Router> { it.routerType === RouterType.CORE }
        private val isEdge: Predicate<Router>
            get() = Predicate<Router> { it.routerType === RouterType.EDGE }

        fun retrieveRouter(routers: List<Router?>, predicate: Predicate<Router?>?): MutableList<Router?>? {
            return routers.stream()
                .filter(predicate)
                .collect(Collectors.toList())
        }
    }

    override fun toString(): String {
        return "Router{" +
            "routerType=" + routerType +
            ", routerId=" + routerId +
            '}'
    }
}
