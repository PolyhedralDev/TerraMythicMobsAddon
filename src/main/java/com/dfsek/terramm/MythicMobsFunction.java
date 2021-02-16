package com.dfsek.terramm;

import com.dfsek.terra.api.structures.parser.lang.ImplementationArguments;
import com.dfsek.terra.api.structures.parser.lang.Returnable;
import com.dfsek.terra.api.structures.parser.lang.functions.Function;
import com.dfsek.terra.api.structures.parser.lang.variables.Variable;
import com.dfsek.terra.api.structures.script.TerraImplementationArguments;
import com.dfsek.terra.api.structures.tokenizer.Position;
import com.dfsek.terra.bukkit.world.BukkitAdapter;
import io.lumine.xikage.mythicmobs.MythicMobs;
import org.bukkit.Location;

import java.util.Map;

public class MythicMobsFunction implements Function<Void> {
    private final Position position;
    private final Returnable<Number> x, y, z;
    private final Returnable<String> mob;

    public MythicMobsFunction(Position position, Returnable<Number> x, Returnable<Number> y, Returnable<Number> z, Returnable<String> mob) {
        this.position = position;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mob = mob;
    }

    @Override
    public ReturnType returnType() {
        return ReturnType.VOID;
    }

    @Override
    public Void apply(ImplementationArguments implementationArguments, Map<String, Variable<?>> map) {
        Location location = BukkitAdapter.adapt(((TerraImplementationArguments) implementationArguments).getBuffer().getOrigin());
        location.add(x.apply(implementationArguments, map).doubleValue(), y.apply(implementationArguments, map).doubleValue(), z.apply(implementationArguments, map).doubleValue());
        MythicMobs.inst().getMobManager().spawnMob(mob.apply(implementationArguments, map), location);
        return null;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
