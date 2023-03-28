<template>

    <v-card outlined>
        <v-card-title>
            ComfimYesOrNo
        </v-card-title>

        <v-card-text>
            <Boolean label="Acccept" v-model="value.acccept" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="comfimYesOrNo"
            >
                ComfimYesOrNo
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ComfimYesOrNoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.acccept = false;
        },
        watch: {
        },
        methods: {
            comfimYesOrNo() {
                this.$emit('comfimYesOrNo', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

