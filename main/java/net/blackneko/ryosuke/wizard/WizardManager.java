package net.blackneko.ryosuke.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WizardManager {
    final private List<Wizard> wizards = new ArrayList<>();

    public Wizard getWizardOrNew(UUID uuid) {
        if (isThereWizard(uuid)) {
            return getWizard(uuid);
        } else {
            return newWizard(uuid);
        }
    }

    private Wizard newWizard(UUID uuid) {
        Wizard wizard = new Wizard(uuid);
        wizards.add(wizard);
        return wizard;
    }

    private boolean isThereWizard(UUID uuid) {
        return wizards.stream().anyMatch(w -> w.uuid() == uuid);
    }

    private Wizard getWizard(UUID uuid) {
        return wizards.stream().filter(w -> w.uuid() == uuid).findAny().orElseThrow(NullPointerException::new);
    }

}
