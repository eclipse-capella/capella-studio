# Migration

Capella offers a migration mechanism. This migration is available through a contextual menu command and is launched between version.

Specific migration contributions can be contributed through an extension point.

The extension points provide two possibilities `migrationContributions` and `migrationContributors`:

* the plug-in org.polarsys.capella.core.data.migration
* and its identifier constraintProviders.

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

## Migration Contributions
This allows to contribute to the migration of the common files `.capella`, `.aird`, and all migrated files.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.2"?>
<plugin>
   <extension
         point="org.polarsys.capella.core.data.migration.migrationContributions">
      <migrationContribution
            class="xxx">
      </migrationContribution>
   </extension>
</plugin>
```

### Detail of the different fields

* `class`: [org.polarsys.capella.core.data.migration.contribution.IMigrationContribution](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.migration/src/org/polarsys/capella/core/data/migration/contribution/IMigrationContribution.java)

## MigrationContributors
This allows to contribute to the migration of additional files while the migration process.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.2"?>
<plugin>
   <extension
         point="org.polarsys.capella.core.data.migration.migrationContributors">
      <migrationContributor
            class="xxx">
      </migrationContributor>
```

### Detail of the different fields

* `class`: [org.polarsys.capella.core.data.migration.contributor.AbstractMigrationContributor](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.migration/src/org/polarsys/capella/core/data/migration/contributor/AbstractMigrationContributor.java)

## Migration contribution

In the major cases, you will contribute to the exiting Capella migration by adding a Migration Contribution.

## Sample

The addon filtering had contributed to migration

* The [Java class](https://github.com/eclipse/capella-filtering/blob/v1.5.2/plugins/org.polarsys.capella.filtering.migration/src/org/polarsys/capella/filtering/migration/contribution/FilteringMigrationContribution.java#L28-L32) defining the contribution. In this case, it says that when we migrate a model refering to the previous version of Filtering, we retrieve the current one. (This has for effect to allow upgrade of nsUri of the Filtering viewpoint)

* Its registration within [plugin.xml](https://github.com/eclipse/capella-filtering/blob/v1.5.0/plugins/org.polarsys.capella.filtering.migration/plugin.xml#L19-L21)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse/capella-filtering/blob/v1.5.0/plugins/org.polarsys.capella.filtering.migration/META-INF/MANIFEST.MF#L11) file we need to depends on `org.polarsys.capella.core.data.migration`
