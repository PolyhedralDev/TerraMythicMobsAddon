package com.dfsek.terramm;

import com.dfsek.terra.api.structures.parser.lang.Returnable;
import com.dfsek.terra.api.structures.parser.lang.functions.FunctionBuilder;
import com.dfsek.terra.api.structures.tokenizer.Position;

import java.util.List;

public class MythicMobsFunctionBuilder implements FunctionBuilder<MythicMobsFunction> {
    @SuppressWarnings("unchecked")
    @Override
    public MythicMobsFunction build(List argumentList, Position position) {
        return new MythicMobsFunction(position, (Returnable<Number>) argumentList.get(0), (Returnable<Number>) argumentList.get(1), (Returnable<Number>) argumentList.get(2), (Returnable<String>) argumentList.get(3));
    }

    @Override
    public int argNumber() {
        return 4;
    }

    @Override
    public Returnable.ReturnType getArgument(int position) {
        switch(position) {
            case 0:
            case 1:
            case 2:
                return Returnable.ReturnType.NUMBER;
            case 3:
                return Returnable.ReturnType.STRING;
            default:
                return null;
        }
    }
}
