package net.Zrips.CMILib.Effects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;

import net.Zrips.CMILib.Colors.CMIChatColor;
import net.Zrips.CMILib.Container.CMIText;
import net.Zrips.CMILib.Items.CMIMaterial;
import net.Zrips.CMILib.Version.Version;

public class CMIEffectManager {

    public enum CMIParticleType {
        SOUND, VISUAL, PARTICLE, NONE;
    }

    public enum CMIParticleDataType {
        Void, DustOptions, ItemStack, BlockData, MaterialData;
    }

    public enum CMIParticle {
        CLICK2(CMIParticleType.SOUND),
        CLICK1(CMIParticleType.SOUND),
        BOW_FIRE(CMIParticleType.SOUND),
        DOOR_TOGGLE(CMIParticleType.SOUND),
        IRON_DOOR_TOGGLE(CMIParticleType.SOUND),
        TRAPDOOR_TOGGLE(CMIParticleType.SOUND),
        IRON_TRAPDOOR_TOGGLE(CMIParticleType.SOUND),
        FENCE_GATE_TOGGLE(CMIParticleType.SOUND),
        DOOR_CLOSE(CMIParticleType.SOUND),
        IRON_DOOR_CLOSE(CMIParticleType.SOUND),
        TRAPDOOR_CLOSE(CMIParticleType.SOUND),
        IRON_TRAPDOOR_CLOSE(CMIParticleType.SOUND),
        FENCE_GATE_CLOSE(CMIParticleType.SOUND),
        EXTINGUISH(CMIParticleType.SOUND),
        RECORD_PLAY(CMIParticleType.SOUND),
        GHAST_SHRIEK(CMIParticleType.SOUND),
        GHAST_SHOOT(CMIParticleType.SOUND),
        BLAZE_SHOOT(CMIParticleType.SOUND),
        ZOMBIE_CHEW_WOODEN_DOOR(CMIParticleType.SOUND),
        ZOMBIE_CHEW_IRON_DOOR(CMIParticleType.SOUND),
        ZOMBIE_DESTROY_DOOR(CMIParticleType.SOUND),
        SMOKE(CMIParticleType.VISUAL),
        STEP_SOUND(CMIParticleType.SOUND),
        POTION_BREAK(CMIParticleType.VISUAL),
        ENDER_SIGNAL(CMIParticleType.VISUAL),
        MOBSPAWNER_FLAMES(CMIParticleType.VISUAL),
        BREWING_STAND_BREW(CMIParticleType.SOUND),
        CHORUS_FLOWER_GROW(CMIParticleType.SOUND),
        CHORUS_FLOWER_DEATH(CMIParticleType.SOUND),
        PORTAL_TRAVEL(CMIParticleType.SOUND),
        ENDEREYE_LAUNCH(CMIParticleType.SOUND),
        FIREWORK_SHOOT(CMIParticleType.SOUND),
        VILLAGER_PLANT_GROW(CMIParticleType.VISUAL),
        DRAGON_BREATH(CMIParticleType.VISUAL),
        ANVIL_BREAK(CMIParticleType.SOUND),
        ANVIL_USE(CMIParticleType.SOUND),
        ANVIL_LAND(CMIParticleType.SOUND),
        ENDERDRAGON_SHOOT(CMIParticleType.SOUND),
        WITHER_BREAK_BLOCK(CMIParticleType.SOUND),
        WITHER_SHOOT(CMIParticleType.SOUND),
        ZOMBIE_INFECT(CMIParticleType.SOUND),
        ZOMBIE_CONVERTED_VILLAGER(CMIParticleType.SOUND),
        BAT_TAKEOFF(CMIParticleType.SOUND),
        END_GATEWAY_SPAWN(CMIParticleType.VISUAL),
        ENDERDRAGON_GROWL(CMIParticleType.SOUND),
        FIREWORKS_SPARK(CMIParticleType.PARTICLE, CMIMaterial.FIRE_CHARGE.getMaterial()),
        CRIT(CMIParticleType.PARTICLE, Material.IRON_SWORD),
        MAGIC_CRIT("CRIT_MAGIC", CMIParticleType.PARTICLE, Material.POTION),
        POTION_SWIRL("MOB_SPELL", "SPELL_MOB", CMIParticleType.PARTICLE, Material.BLAZE_ROD),
        POTION_SWIRL_TRANSPARENT("MOB_SPELL_AMBIENT", "SPELL_MOB_AMBIENT", CMIParticleType.PARTICLE, Material.BLAZE_POWDER),
        SPELL(CMIParticleType.PARTICLE, Material.MILK_BUCKET),
        INSTANT_SPELL("SPELL_INSTANT", CMIParticleType.PARTICLE, Material.GLASS_BOTTLE),
        WITCH_MAGIC("SPELL_WITCH", CMIParticleType.PARTICLE, Material.SPIDER_EYE),
        NOTE(CMIParticleType.PARTICLE, Material.NOTE_BLOCK),
        PORTAL(CMIParticleType.PARTICLE, Material.OBSIDIAN),
        FLYING_GLYPH("ENCHANTMENT_TABLE", CMIParticleType.PARTICLE, CMIMaterial.ENCHANTING_TABLE.getMaterial()),
        FLAME(CMIParticleType.PARTICLE, CMIMaterial.FIRE_CHARGE.getMaterial()),
        LAVA_POP("LAVA", CMIParticleType.PARTICLE, Material.FLINT_AND_STEEL),
        FOOTSTEP(CMIParticleType.PARTICLE, Material.IRON_BOOTS),
        SPLASH("WATER_SPLASH", CMIParticleType.PARTICLE, Material.STICK),
        PARTICLE_SMOKE("SMOKE", "SMOKE_NORMAL", CMIParticleType.PARTICLE, Material.ANVIL),
        EXPLOSION_HUGE("HUGE_EXPLOSION", CMIParticleType.PARTICLE, Material.FURNACE),
        EXPLOSION_LARGE("LARGE_EXPLODE", CMIParticleType.PARTICLE, Material.FURNACE),
        EXPLOSION("EXPLODE", "EXPLOSION_NORMAL", CMIParticleType.PARTICLE, Material.TNT),
        VOID_FOG("DEPTH_SUSPEND", "SUSPENDED_DEPTH", CMIParticleType.PARTICLE, CMIMaterial.SALMON.getMaterial()),
        SMALL_SMOKE("TOWN_AURA", CMIParticleType.PARTICLE, CMIMaterial.MYCELIUM.getMaterial()),
        CLOUD(CMIParticleType.PARTICLE, CMIMaterial.COBWEB.getMaterial()),
        @Deprecated
        COLOURED_DUST(Arrays.asList("RED_DUST", "REDSTONE"), CMIParticleType.PARTICLE, Material.REDSTONE, CMIParticleDataType.DustOptions),
        DUST(Arrays.asList("RED_DUST", "REDSTONE", "COLOURED_DUST"), CMIParticleType.PARTICLE, Material.REDSTONE, CMIParticleDataType.DustOptions),
        SNOWBALL_BREAK("SNOW_BALL_POOF", "SNOW_BALL", CMIParticleType.PARTICLE, CMIMaterial.SNOWBALL.getMaterial()),
        WATERDRIP("DRIP_WATER", "WATER_DROP", CMIParticleType.PARTICLE, Material.WATER_BUCKET),
        LAVADRIP("DRIP_LAVA", CMIParticleType.PARTICLE, Material.LAVA_BUCKET),
        SNOW_SHOVEL(CMIParticleType.PARTICLE, CMIMaterial.DIAMOND_SHOVEL.getMaterial()),
        SLIME(CMIParticleType.PARTICLE, Material.SLIME_BALL),
        HEART(CMIParticleType.PARTICLE, CMIMaterial.ROSE_RED.getMaterial()),
        VILLAGER_THUNDERCLOUD("ANGRY_VILLAGER", "VILLAGER_ANGRY", CMIParticleType.PARTICLE, Material.EMERALD),
        HAPPY_VILLAGER("VILLAGER_HAPPY", CMIParticleType.PARTICLE, Material.BOOK),
        LARGE_SMOKE("SMOKE_LARGE", CMIParticleType.PARTICLE, Material.FURNACE),
        ITEM_BREAK("ICON_CRACK", CMIParticleType.NONE, Material.DIAMOND_BOOTS),

        // 1.13
        WATER_BUBBLE(),
        WATER_WAKE(),
        SUSPENDED(),
        BARRIER(),
        MOB_APPEARANCE(),
        END_ROD(),
        DAMAGE_INDICATOR(),
        SWEEP_ATTACK(),
        TOTEM(),
        SPIT(),
        SQUID_INK(),
        BUBBLE_POP(),
        CURRENT_DOWN(),
        BUBBLE_COLUMN_UP(),
        NAUTILUS(),
        DOLPHIN(),

//	Requires extra data when displaying
//	ITEM_CRACK("ItemCrack"),
//	BLOCK_DUST("block_dust"),
//	FALLING_DUST("falling_dust"),

        //1.16
        WATER_SPLASH(),
        CAMPFIRE_SIGNAL_SMOKE(),
        CAMPFIRE_COSY_SMOKE(),
        SNEEZE(),
        COMPOSTER(),
        FLASH(),
        FALLING_LAVA(),
        LANDING_LAVA(),
        FALLING_WATER(),
        DRIPPING_HONEY(),
        FALLING_HONEY(),
        LANDING_HONEY(),
        FALLING_NECTAR(),
        SOUL_FIRE_FLAME(),
        ASH(),
        CRIMSON_SPORE(),
        WARPED_SPORE(),
        SOUL(),
        DRIPPING_OBSIDIAN_TEAR(),
        FALLING_OBSIDIAN_TEAR(),
        LANDING_OBSIDIAN_TEAR(),
        REVERSE_PORTAL(),
        WHITE_ASH(),

        // 1.17
        LIGHT(),
//	Requires extra data when displaying
//	DUST_COLOR_TRANSITION("dust_color_transition"),
//	VIBRATION("vibration"),
        FALLING_SPORE_BLOSSOM(),
        SPORE_BLOSSOM_AIR(),
        SMALL_FLAME(),
        SNOWFLAKE(),
        DRIPPING_DRIPSTONE_LAVA(),
        FALLING_DRIPSTONE_LAVA(),
        DRIPPING_DRIPSTONE_WATER(),
        FALLING_DRIPSTONE_WATER(),
        GLOW_SQUID_INK(),
        GLOW(),
        WAX_ON(),
        WAX_OFF(),
        ELECTRIC_SPARK(),
        SCRAPE(),

        // 1.18
        BLOCK_MARKER(CMIParticleType.PARTICLE, CMIMaterial.BARRIER.getMaterial(), CMIParticleDataType.BlockData),

        // 1.19
        SONIC_BOOM(),
        SCULK_SOUL(),
//	SCULK_CHARGE(),
        SCULK_CHARGE_POP(),
//	SHRIEK("shriek"),        
        CHERRY_LEAVES(),

        // 1.20.5
//        POOF("poof"),
//        EXPLOSION_EMITTER("explosion_emitter"),
//        FIREWORK("firework"),
//        BUBBLE("bubble"),
//        FISHING("fishing"),
//        UNDERWATER("underwater"),
//        ENCHANTED_HIT("enchanted_hit"),
//        EFFECT("effect"),
//        INSTANT_EFFECT("instant_effect"),
//        ENTITY_EFFECT("entity_effect"),
//        WITCH("witch"),
//        DRIPPING_WATER("dripping_water"),
//        DRIPPING_LAVA("dripping_lava"),
//        MYCELIUM("mycelium"),
//        ENCHANT("enchant"),

//        ITEM_SNOWBALL("item_snowball"),
//        ITEM_SLIME("item_slime"),
//        ITEM("item"),
//        BLOCK("block"),
//        RAIN("rain"),
//        ELDER_GUARDIAN("elder_guardian"),
//        FALLING_DUST("falling_dust"),
//        TOTEM_OF_UNDYING("totem_of_undying"),
//        DUST_COLOR_TRANSITION("dust_color_transition", CMIParticleType.PARTICLE, Material.STONE, CMIParticleDataType.DustOptions),
//        VIBRATION("vibration"),
//        SCULK_CHARGE("sculk_charge"),
//        SHRIEK("shriek"),
//        EGG_CRACK("egg_crack"),
//        DUST_PLUME("dust_plume"),
//        WHITE_SMOKE("white_smoke"),
//        GUST("gust"),
//        SMALL_GUST("small_gust"),
//        GUST_EMITTER_LARGE("gust_emitter_large"),
//        GUST_EMITTER_SMALL("gust_emitter_small"),
//        TRIAL_SPAWNER_DETECTION("trial_spawner_detection"),
//        TRIAL_SPAWNER_DETECTION_OMINOUS("trial_spawner_detection_ominous"),
//        VAULT_CONNECTION("vault_connection"),
//        INFESTED("infested"),
//        ITEM_COBWEB("item_cobweb"),
//        DUST_PILLAR("dust_pillar"),
//        OMINOUS_SPAWNING("ominous_spawning"),
//        RAID_OMEN("raid_omen"),
//        TRIAL_OMEN("trial_omen"),

        ;

        static HashMap<String, CMIParticle> byName = new HashMap<String, CMIParticle>();
        static HashMap<Object, CMIParticle> byType = new HashMap<Object, CMIParticle>();

        static {
            for (CMIParticle one : CMIParticle.values()) {

                if (one.equals(CMIParticle.COLOURED_DUST) && Version.isCurrentEqualOrHigher(Version.v1_20_R4))
                    continue;

                if (one.equals(CMIParticle.DUST) && Version.isCurrentEqualOrLower(Version.v1_20_R3))
                    continue;

                byName.put(one.toString().replace("_", "").toLowerCase(), one);
                byName.put(one.getName().replace("_", "").replace(" ", "").toLowerCase(), one);

                if (!one.getSecondaryNames().isEmpty()) {
                    for (String name : one.getSecondaryNames()) {
                        byName.put(name.replace("_", "").toLowerCase(), one);
                    }
                }

                if (one.getParticle() != null)
                    byType.put(one.getParticle(), one);
            }
        }

        private String name;
        private List<String> secondaryNames = new ArrayList<>();

        private CMIParticleType type;
        private Material icon;
        private Object particle;
        private Effect effect;
        private Object EnumParticle;
        private int[] extra;
        private CMIParticleDataType dataType = CMIParticleDataType.Void;

        CMIParticle() {
            this(new ArrayList<>(), null, null, null);
        }

        CMIParticle(CMIParticleType type) {
            this(new ArrayList<>(), type, null, null);
        }

        CMIParticle(CMIParticleType type, Material icon) {
            this(new ArrayList<>(), type, icon, CMIParticleDataType.Void);
        }

        CMIParticle(CMIParticleType type, Material icon, CMIParticleDataType dataType) {
            this(new ArrayList<>(), type, icon, dataType);
        }

        CMIParticle(String secondaryName, CMIParticleType type, Material icon) {
            this(Arrays.asList(secondaryName), type, icon, null);
        }

        CMIParticle(String name, String secondaryName, CMIParticleType type, Material icon) {
            this(Arrays.asList(name, secondaryName), type, icon, CMIParticleDataType.Void);
        }

        CMIParticle(List<String> secondaryNames, CMIParticleType type, Material icon, CMIParticleDataType dataType) {
            this.name = name == null ? CMIText.everyFirstToUpperCase(this.toString()) : name;
            this.secondaryNames = secondaryNames;

            this.type = type == null ? CMIParticleType.PARTICLE : type;
            this.icon = icon == null ? Material.STONE : icon;
            this.dataType = dataType == null ? CMIParticleDataType.Void : dataType;
        }

        public String getName() {
            return name;
        }

        @Deprecated
        public int getId() {
            return 0;
        }

        public CMIParticleType getType() {
            return type;
        }

        public boolean isParticle() {
            return type == CMIParticleType.PARTICLE;
        }

        public boolean isColored() {
            return this.equals(DUST);
        }

        public static boolean isParticle(Effect effect) {
            if (effect == null)
                return false;
            CMIParticle cmiEffect = getCMIParticle(effect.toString());
            if (cmiEffect == null)
                return false;
            return cmiEffect.isParticle();
        }

        public static Material getSafeIcon(Effect effect) {
            CMIParticle cmiEffect = getCMIParticle(effect.toString());
            if (cmiEffect == null)
                return Material.STONE;
            return cmiEffect.getIcon() == null ? Material.STONE : cmiEffect.getIcon();
        }

        public Material getSafeIcon() {
            return getIcon() == null ? Material.STONE : getIcon();
        }

        public static CMIParticle getCMIParticle(String name) {
            if (name == null)
                return null;

            name = name.replace("_", "").toLowerCase();

            return byName.get(name);
        }

        public static CMIEffect getCMIEffect(String name) {
            CMIEffect cmiEffect = null;
            if (name == null)
                return null;
            name = name.replace("_", "").toLowerCase();
            CMIMaterial mat = null;
            Color color = null;
            if (name.contains(":")) {
                String sub = name.split(":", 2)[1];

                for (String one : sub.split(":")) {
                    if (color == null) {
                        if (one.contains(",")) {
                            String[] split = one.split(",");
                            try {
                                color = Color.fromRGB(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                            } catch (Throwable e) {

                            }
                        }
                        if (color == null) {
                            CMIChatColor c = CMIChatColor.getColor(one);
                            if (c != null) {
                                color = c.getRGBColor();
                            }
                        }
                        if (color == null) {
                            CMIChatColor cmicolor = CMIChatColor.getColor(one);
                            if (cmicolor != null) {
                                color = Color.fromRGB(cmicolor.getRed(), cmicolor.getGreen(), cmicolor.getBlue());
                            }
                        }
                        if (color != null)
                            continue;
                    }
                    mat = CMIMaterial.get(one);
                }

                name = name.split(":", 2)[0];
            }

            CMIParticle cmiParticle = getCMIParticle(name);

            if (cmiParticle == null)
                return null;

            cmiEffect = new CMIEffect(cmiParticle);

            if (Version.isCurrentEqualOrHigher(Version.v1_9_R1) && cmiEffect.getParticle() == null)
                return null;

            if (Version.isCurrentLower(Version.v1_13_R1) && cmiEffect.getParticle().getEffect() == null)
                return null;

            if (color != null)
                cmiEffect.setColor(color);
            if (mat != null && mat.isBlock())
                cmiEffect.setMaterial(mat);

            return cmiEffect;
        }

//	public static Effect getEffect(String name) {
//	    CMIParticle cmiEffect = getCMIParticle(name);
////	    Bukkit.getConsoleSender().sendMessage("1 "+name);
////	    Bukkit.getConsoleSender().sendMessage("2 "+cmiEffect);
//
//	    if (cmiEffect != null) {
//		if (!cmiEffect.getType().equals(CMIParticleType.PARTICLE))
//		    return null;
//		for (Effect one : Effect.values()) {
//		    if (one.toString().equalsIgnoreCase(cmiEffect.name()))
//			return one;
//		    if (one.toString().equalsIgnoreCase(cmiEffect.getName()))
//			return one;
//		}
//	    } else {
//		for (Effect one : Effect.values()) {
//		    if (one.toString().replace("_", "").equalsIgnoreCase(name)) {
//			try {
//			    if (one.getType() != Type.VISUAL)
//				return null;
//			} catch (Exception | NoSuchMethodError e) {
//			    return null;
//			}
//			return one;
//		    }
//		}
//	    }
//	    return null;
//	}

        public Effect getEffect() {
            if (effect != null)
                return effect;
            if (!isParticle())
                return null;

            String n = this.toString().replace("_", "").toLowerCase();
            for (Effect one : Effect.values()) {
                if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                    continue;
                effect = one;
                break;
            }

            if (effect != null)
                return effect;

            n = name().replace("_", "").toLowerCase();
            for (Effect one : Effect.values()) {
                if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                    continue;
                effect = one;
                break;
            }

            if (effect != null)
                return effect;

            n = getName().replace("_", "").toLowerCase();
            for (Effect one : Effect.values()) {
                if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                    continue;
                effect = one;
                break;
            }

            if (effect != null)
                return effect;

            for (String oneS : getSecondaryNames()) {
                n = oneS.replace("_", "").toLowerCase();
                if (n.isEmpty())
                    return effect == null ? null : effect;

                for (Effect one : Effect.values()) {
                    if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                        continue;
                    effect = one;
                    break;
                }
            }

            if (effect != null)
                return effect;

            for (Effect one : Effect.values()) {
                if (!one.toString().toLowerCase().replace("_", "").contains(n))
                    continue;
                effect = one;
                break;
            }

            return effect == null ? null : effect;

        }

        public Material getIcon() {
            return icon == null ? Material.STONE : icon;
        }

        public static List<CMIParticle> getParticleList() {
            List<CMIParticle> ls = new ArrayList<CMIParticle>();
            for (CMIParticle one : CMIParticle.values()) {
                if (!one.isParticle())
                    continue;
                if (Version.isCurrentEqualOrHigher(Version.v1_9_R1) && one.getParticle() == null)
                    continue;
                if (Version.isCurrentLower(Version.v1_13_R1) && one.getEffect() == null)
                    continue;
                ls.add(one);
            }
            return ls;
        }

        public CMIParticle getNextPartcileEffect() {

            List<CMIParticle> ls = getParticleList();
            for (int i = 0; i < ls.size(); i++) {
                CMIParticle next = ls.get(i);
                if (next == null)
                    continue;

                if (!next.isParticle())
                    continue;
                if (Version.isCurrentEqualOrHigher(Version.v1_9_R1) && next.getParticle() == null)
                    continue;

                if (next.equals(this)) {
                    if (i == ls.size() - 1)
                        return ls.get(0);
                    return ls.get(i + 1);
                }
            }
            return this;
        }

        public CMIParticle getPrevParticleEffect() {
            List<CMIParticle> ls = getParticleList();
            for (int i = 0; i < ls.size(); i++) {
                CMIParticle next = ls.get(i);

                if (next == null)
                    continue;

                if (Version.isCurrentEqualOrHigher(Version.v1_9_R1) && next.getParticle() == null)
                    continue;

                if (!next.isParticle())
                    continue;
                if (next.equals(this)) {
                    if (i == 0)
                        return ls.get(ls.size() - 1);
                    return ls.get(i - 1);
                }
            }
            return this;
        }

        @Deprecated
        public String getSecondaryName() {
            return this.secondaryNames.isEmpty() ? "" : secondaryNames.get(0);
        }

        @Deprecated
        public void setSecondaryName(String secondaryName) {
            this.secondaryNames.clear();
            this.secondaryNames.add(secondaryName);
        }

        public List<String> getSecondaryNames() {
            return this.secondaryNames;
        }

        public org.bukkit.Particle getParticle() {

            if (Version.isCurrentEqualOrLower(Version.v1_8_R3))
                return null;

            if (particle != null)
                return (org.bukkit.Particle) particle;

            String n = this.toString().replace("_", "").toLowerCase();
            for (org.bukkit.Particle one : org.bukkit.Particle.values()) {
                if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                    continue;
                particle = one;
                break;
            }

            if (particle != null)
                return (org.bukkit.Particle) particle;

            n = name().replace("_", "").toLowerCase();
            for (org.bukkit.Particle one : org.bukkit.Particle.values()) {
                if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                    continue;
                particle = one;
                break;
            }

            if (particle != null)
                return (org.bukkit.Particle) particle;

            n = getName().replace("_", "").toLowerCase();
            for (org.bukkit.Particle one : org.bukkit.Particle.values()) {
                if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                    continue;
                particle = one;
                break;
            }

            if (particle != null)
                return (org.bukkit.Particle) particle;

            for (String oneS : getSecondaryNames()) {
                n = oneS.replace("_", "").toLowerCase();
                if (n.isEmpty())
                    return particle == null ? null : (org.bukkit.Particle) particle;

                for (org.bukkit.Particle one : org.bukkit.Particle.values()) {
                    if (!one.toString().toLowerCase().replace("_", "").equalsIgnoreCase(n))
                        continue;
                    particle = one;
                    break;
                }
            }

            if (particle != null)
                return (org.bukkit.Particle) particle;

            for (org.bukkit.Particle one : org.bukkit.Particle.values()) {
                if (!one.toString().toLowerCase().replace("_", "").contains(n))
                    continue;
                particle = one;
                break;
            }

            return particle == null ? null : (org.bukkit.Particle) particle;
        }

        public Object getEnumParticle() {
            return EnumParticle;
        }

        public void setEnumParticle(Object enumParticle) {
            EnumParticle = enumParticle;
        }

        public int[] getExtra() {
            return extra;
        }

        public void setExtra(int[] extra) {
            this.extra = extra;
        }

        public CMIParticleDataType getDataType() {
            return dataType;
        }
    }

}
