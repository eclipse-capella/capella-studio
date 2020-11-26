#!/bin/sh
# ====================================================================
# Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
# This program and the accompanying materials are made available under the
# terms of the Eclipse Public License 2.0 which is available at
# http://www.eclipse.org/legal/epl-2.0
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#     Thales - initial API and implementation
# ====================================================================

# ====================================================================
#
# This script clean nightly published update site from runtime core , runtime, sdk and products.
# Keep only 5 last builds and delete older one if DRY_RUN variable is set to true
# If DRY_RUN variable is set to false only show the updatesite to remove
#
# ====================================================================


# Create a p2 composite repo to setup a redirect
clean_component() {
	COMPONENT_NAME="$1"
    ROOT_COMPONENT_DIR="$2"
	echo "List of file and folder in $ROOT_COMPONENT_DIR before delete"
	ls -al $ROOT_DIR
    rm -f all$COMPONENT_NAME.txt kept$COMPONENT_NAME.txt removed$COMPONENT_NAME.txt
	# Find all nightly builds
	find "$ROOT_COMPONENT_DIR" -type d -maxdepth 1 | sort | grep -E '/[0-9]\.[0-9]\.[0-9]-N' > all$COMPONENT_NAME.txt
	# For each X.Y stream, keep the 5 most recent X.Y.Z build (whichever Z)
	for s in $(find "$ROOT_COMPONENT_DIR" -type d -maxdepth 1 | sort | grep -E '/[0-9]\.[0-9]\.[0-9]-N' | sed -r -e 's|.*/([0-9]\.[0-9])\.[0-9]-N.*|\1|' | sort -u); do
		find "$ROOT_COMPONENT_DIR" -type d -maxdepth 1 -name "${s}.[0-9]-N*" | sort | tail -n 5
	done > kept$COMPONENT_NAME.txt
	# Identify which ones can be removed
	comm -23 all$COMPONENT_NAME.txt kept$COMPONENT_NAME.txt > removed$COMPONENT_NAME.txt
	
	if [ "$DRY_RUN" = "false" ]; then
		for d in $(cat removed$COMPONENT_NAME.txt); do
			rm -rf "${d}"
		done
	fi
	echo "List of file and folder in $ROOT_COMPONENT_DIR after delete"
	ls -al $ROOT_DIR
}

# Get folder path contain this script
BASEDIR=$(dirname $0)

# Extract global parameters (ie Publish fix part location)
. $BASEDIR/global-parameters.sh "nightly"

ROOT_UPDATE_DIR="$PUBLISH_FOLDER_ROOT/updates/nightly"
SDK_DIR="$ROOT_UPDATE_DIR/sdk"
PRODUCTS_DIR="$PUBLISH_FOLDER_ROOT/products/nightly"

clean_component "sdk" "$SDK_DIR"
clean_component "products" "$PRODUCTS_DIR"

